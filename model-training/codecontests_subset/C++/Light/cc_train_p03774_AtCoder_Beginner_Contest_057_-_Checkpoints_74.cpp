#include <bits/stdc++.h>
using namespace std;
int N,M,AB[55][2],CD[55][2];
int main(){
    cin>>N>>M;
    for(int i=0;i<N;i++)cin>>AB[i][0]>>AB[i][1];
    for(int i=0;i<M;i++)cin>>CD[i][0]>>CD[i][1];
    for(int i=0;i<N;i++){
        int x=AB[i][0],y=AB[i][1],z=1e9,w=-1;
        for(int j=0;j<M;j++){
            int zz=abs(x-CD[j][0])+abs(y-CD[j][1]);
            if(zz<z){
                z=zz;
                w=j;
            }
        }
        cout<<w+1<<endl;
    }
}
