#include<bits/stdc++.h>
using namespace std;
int main(){
    int n,m;
    cin>>n>>m;
    int ax[n],ay[n],bx[m],by[m];
    for(int i=0;i<n;i++)cin>>ax[i]>>ay[i];
    for(int i=0;i<m;i++)cin>>bx[i]>>by[i];
    for(int i=0;i<n;i++){
        int ans=0,d=1000000000;
        for(int j=0;j<m;j++){
            if(abs(ax[i]-bx[j])+abs(ay[i]-by[j])<d){
                ans=j,d=abs(ax[i]-bx[j])+abs(ay[i]-by[j]);
            }
        }
        cout<<ans+1<<endl;
    }
    return 0;
}