#include <bits/stdc++.h> 
using namespace std;
typedef long long ll;
const int N = 1e5+7;
void dfs(int now,int n,string ans,int k){
	if(now == n){
		cout << ans << "\n";
		return ;
	}
	for(int i = 0;i <= k;++i) dfs(now+1,n,ans+(char)('a'+i),max(k,i+1));
	return ;
}
int main() {
    int n;
	cin >> n;
	dfs(0,n,"",0);
    return 0;
}