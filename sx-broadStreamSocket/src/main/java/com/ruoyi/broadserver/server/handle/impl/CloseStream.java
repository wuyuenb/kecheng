package com.ruoyi.broadserver.server.handle.impl;

import com.ruoyi.broadserver.global.ProtocolsToClient;
import com.ruoyi.broadserver.server.handle.DefaultCommand;
import org.apache.mina.core.session.IoSession;
import com.ruoyi.broad.utils.bConvert;

//关闭流媒体传输
public class CloseStream extends DefaultCommand {

	public CloseStream(IoSession session, byte[] content) {
		super(session, content);
		// TODO Auto-generated constructor stub
	}

	@Override
	public byte[] execute() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		byte[] data = bConvert.subBytes(content, 5, 6);
		String info = new String(data);

		String command = save(info)?"1":"0";//保存信息
		
		
		datainfo = info;
		loggersession();//插入日志
	
		return returnBytes(ProtocolsToClient.CLOSESTREAM, command, "OK");
	}

	@Override
	public boolean save(Object obj) {
		// TODO Auto-generated method stub
		if(obj.equals("ending")) {
			//to do sth
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Object get(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
