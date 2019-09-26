private byte getIdForRecipient(String recipient) {
  Integer currentId;
    
  if (idMap.containsKey(recipient)) {
    currentId = idMap.get(recipient);
    idMap.remove(recipient);
  } 
  else {
    currentId = Integer.valueOf(0);
  }

  byte id  = currentId.byteValue();
  idMap.put(recipient, Integer.valueOf((currentId.intValue() + 1) % 255));
    
  return id;
}