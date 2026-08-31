#include<bits/stdc++.h>
using namespace std;
inline int read(){
	int X=0; bool flag=1; char ch=getchar();
	while(ch<'0'||ch>'9') {if(ch=='-') flag=0; ch=getchar();}
	while(ch>='0'&&ch<='9') {X=(X<<1)+(X<<3)+ch-'0'; ch=getchar();}
	if(flag) return X;
	return ~(X-1);
}
int T,n,m;
typedef long long ll;
ll mod=1e9+7,ans=0ll;
ll f[200050];
int main(){
	cin>>T;
	for(int i=0;i<=8;i++){
			f[i]=2ll;
		}
	for(int i=9;i<=200005;i++){
		if(i<10)f[i]=f[i-9]+1;
		else f[i]=f[i-9]+f[i-10];
		if(f[i]>mod)f[i]%=mod;
	}
	while(T--){
		n=read();m=read();
		ans=0ll;
		while(n){
			int t=n%10;
			if(m>=10-t)ans+=f[m-(10-t)];
			else ans++;
			n/=10;
			if(ans>mod)ans%=mod;
		}
		printf("%d\n",ans%mod);
	}
}