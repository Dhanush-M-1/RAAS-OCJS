#include<bits/stdc++.h>
using namespace std;
const int N=1e5+5;
const int P=1e9+7;
int n,m,a[N],ans[N],tot;
int main()
{
    cin>>n>>m;
    for(int i=0;i<m;i++)cin>>a[i];
    ans[0]=1;
    for(int i=1;i<=n;i++){
        if(a[tot]==i){tot++;continue;}
        ans[i]=i>1?(ans[i-1]+ans[i-2])%P:ans[i-1];
    }
    cout<<ans[n];
    return 0;
}