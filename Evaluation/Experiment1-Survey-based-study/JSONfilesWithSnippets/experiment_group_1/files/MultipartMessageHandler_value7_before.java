private byte getIdForRecipient(String recipient) {
  Integer currentId;
    
  if (idMap.containsKey(recipient)) {
    currentId = idMap.get(recipient);
    idMap.remove(recipient);
  } 
  else {
    currentId = new Integer(0);
  }

  byte id  = currentId.byteValue();
  idMap.put(recipient, new Integer((currentId.intValue() + 1) % 255));
    
  return id;
}  