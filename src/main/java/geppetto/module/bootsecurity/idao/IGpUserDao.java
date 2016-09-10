package geppetto.module.bootsecurity.idao;

import com.pwc.domain.core.GpUser;

public interface IGpUserDao {

	public GpUser insert(GpUser gpUser) throws Exception;
}
