public class Yaaic
{
    public static Yaaic instance;

    private SparseArray<Server> servers;
    private boolean serversLoaded = false;

    private Yaaic()
    {
        servers = new SparseArray<Server>();
    }

    public void loadServers(Context context)
    {
        if (!serversLoaded) {
            Database db = new Database(context);
            servers = db.getServers();
            db.close();

            // context.sendBroadcast(new Intent(Broadcast.SERVER_UPDATE));
            serversLoaded = true;
        }
    }
}