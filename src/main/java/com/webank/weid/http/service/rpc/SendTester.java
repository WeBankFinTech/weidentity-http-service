/*
 *       Copyright© (2019) WeBank Co., Ltd.
 *
 *       This file is part of weid-http-service.
 *
 *       weid-http-service is free software: you can redistribute it and/or modify
 *       it under the terms of the GNU Lesser General Public License as published by
 *       the Free Software Foundation, either version 3 of the License, or
 *       (at your option) any later version.
 *
 *       weid-http-service is distributed in the hope that it will be useful,
 *       but WITHOUT ANY WARRANTY; without even the implied warranty of
 *       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *       GNU Lesser General Public License for more details.
 *
 *       You should have received a copy of the GNU Lesser General Public License
 *       along with weid-http-service.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.webank.weid.http.service.rpc;

import com.webank.weid.http.constant.WeIdentityServiceEndpoint;
import com.webank.weid.http.protocol.request.EndpointRequest;

public class SendTester {

    public static void main(String[] args) throws Exception {
        // Test direct send via client
        String hostport = "127.0.1:6095";
        // need boot up server first
        RpcClient rpcClient = new RpcClient(hostport);
        EndpointRequest endpointRequest = new EndpointRequest();
        endpointRequest.setRequestName(WeIdentityServiceEndpoint.FETCH_FUNCTION);
        endpointRequest.setRequestBody("123");
        String uuid = RpcConnectionHandler.send(hostport, endpointRequest).getRespBody();
        String endpointInfoString = RpcConnectionHandler.get(uuid).getRespBody();
        System.out.println(endpointInfoString);
        RpcConnectionHandler.init();
    }

}
