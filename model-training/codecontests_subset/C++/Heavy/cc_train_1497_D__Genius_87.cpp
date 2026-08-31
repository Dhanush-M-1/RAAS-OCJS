#include <bits/stdc++.h>
using namespace std;
#define rep(i,a,n) for(int i=a;i<n;i++)
#define per(i,a,n) for(int i=a;i>=n;i--)
typedef long long ll;
const int maxn =100050;
const int mod = 998244353;
const int NIL = -1;
struct node {
    int tag;
    int value;
}node[5005];
ll dp[5005];
int main(){
    int t;
    scanf("%d",&t);
    while(t--){
        int n;
        scanf("%d",&n);
        rep(i,1,n+1) scanf("%d",&node[i].tag);
        rep(i,1,n+1) {
            scanf("%d",&node[i].value);
            dp[i] = 0ll;
        }
        rep(i,2,n+1){
            per(j,i-1,1){
                if(node[i].tag != node[j].tag){
                    ll dpi = dp[i], dpj = dp[j];
                    ll bonus = abs(node[i].value - node[j].value);
                    dp[i] = max(dp[i], dpj + bonus);
                    dp[j] = max(dp[j], dpi + bonus);
                }
            }
        }
        ll ans = 0;
        rep(i,1,n+1){
            ans = max(ans, dp[i]);
        }
        printf("%lld\n",ans);
    }
    //system("pause");
    return 0;
}
