#include<cstdio>
#include<algorithm>
using namespace std;

int a[7]={1,10,100,1000,10000,100000,1000000};
int ans;

int solve(int n){
    int res=0;
    if(n<10) return n;
    ans++;
    for(int i=0;a[i]<n;i++){
        res=max(res,(n/a[i])*(n%a[i]));
    }
    return solve(res);
}

int main(){
    int q;
    scanf("%d",&q);
    for(int i=0;i<q;i++){
        int n;
        ans=0;
        scanf("%d",&n);
        solve(n);
        printf("%d\n",ans);
    }
    return 0;
}