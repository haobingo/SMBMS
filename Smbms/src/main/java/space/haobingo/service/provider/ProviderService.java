package space.haobingo.service.provider;

import space.haobingo.pojo.Provider;

import java.util.List;

public interface ProviderService {
    public List<Provider> getProviderList(String proName, String proCode);
    public boolean add(Provider provider);
    public int deleteProviderById(String delId);
    public Provider getProviderById(String id);
    public boolean modify(Provider provider);

}
