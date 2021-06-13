package Business;

import Business.DTO.TransferObject;

public interface Transactions {
    public void addNewCustomer(TransferObject object);
    public void addNewFilm(TransferObject object);
    public void addNewGame(TransferObject object);
    public void rentItem(TransferObject object);
    public void returnItem(TransferObject object);
    public void addPenalty(TransferObject object);
}
