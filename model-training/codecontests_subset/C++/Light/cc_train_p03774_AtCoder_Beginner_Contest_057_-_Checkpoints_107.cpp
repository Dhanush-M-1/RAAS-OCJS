#include<bits/stdc++.h>
using namespace std;
int inf=1e9;
int main(){
	int n,m;cin>>n>>m;
	vector<int>a(n),b(n),c(m),d(m);
    vector<int>ans(n,-1);
  	for(int i=0;i<n;i++)cin>>a[i]>>b[i];
  	for(int i=0;i<m;i++)cin>>c[i]>>d[i];

	for(int i=0;i<n;i++){
		int dst=inf;
		for(int j=0;j<m;j++){
			if(dst>abs(a[i]-c[j])+abs(b[i]-d[j])){
              ans[i]=j+1;
              dst=abs(a[i]-c[j])+abs(b[i]-d[j]);
	}
	}
    }
	for(auto&& u:ans)cout<<u<<endl;
}
