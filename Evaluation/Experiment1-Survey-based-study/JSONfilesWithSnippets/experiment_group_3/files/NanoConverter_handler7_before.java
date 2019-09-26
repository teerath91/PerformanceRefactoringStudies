Handler handlerCloseThreadforce = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        progressDialog.dismiss();}
};
Handler handlerCloseforce = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        handlerCloseThreadforce.sendEmptyMessage(0);}
};