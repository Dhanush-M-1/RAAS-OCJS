#include <vector>
#include <algorithm>
#include <set>
#include <map>
#include <queue>
#include <stack>
#include <iostream>
#include <cstdio>
#include <cmath>
#include <cstring>
using namespace std;
typedef long long ll;
typedef pair<ll,ll> P;
typedef double db;
ll m;
string a,b;
ll dp[501][10][2][2][500];//dp[??????????????????][??°???][0:up(next)  1:down(next)][0:suf 1:below][mod]
ll d[501];
ll solve(string s){
	ll T=1;
	ll L=s.size();
	if(L==1) return (s[0]-'0')/m;
	for(ll i=1;i<=L;i++){
		d[L-i]=T;
		T=(T*10)%m;
	}
	memset(dp,0,sizeof(dp));
	for(ll i=0;i<2;i++){
		for(ll j=1;j<s[0]-'0';j++){
			dp[0][j][i][1][j*d[0]%m]=1;
		}
		dp[0][s[0]-'0'][i][0][d[0]*(s[0]-'0')%m]=1;
	}
	for(ll i=1;i<L;i++){
		for(ll j=1;j<10;j++){
			dp[i][j][0][1][j*d[i]%m]=dp[i][j][1][1][j*d[i]%m]=1;
		}
	}
	for(ll i=0;i<L-1;i++){
		for(ll j=0;j<2;j++){//down up
			for(ll w=0;w<2;w++){//sufbelow
				for(ll k=0;k<10;k++){
					for(ll p=0;p<m;p++){
						if(j){//down
							if(w){//below
								for(ll next=0;next<k;next++){
									dp[i+1][next][0][1][(p+d[i+1]*next)%m]= (dp[i+1][next][0][1][(p+d[i+1]*next)%m]+dp[i][k][1][1][p])%10000;
								}
							}
							else{//suf
								for(ll next=0;next<s[i+1]-'0'&&next<k;next++){
									dp[i+1][next][0][1][(p+d[i+1]*next)%m]=(dp[i+1][next][0][1][(p+d[i+1]*next)%m]+dp[i][k][1][0][p])%10000;
								}
								if(s[i+1]<s[i]&&s[i+1]-'0'<k) dp[i+1][s[i+1]-'0'][0][0][(p+d[i+1]*(s[i+1]-'0'))%m]=(dp[i+1][s[i+1]-'0'][0][0][(p+d[i+1]*(s[i+1]-'0'))%m]+dp[i][k][1][0][p])%10000;
							}
						}//dp[??????????????????][??°???][0:up(next)  1:down(next)][0:suf 1:below][mod]
						else{//up
							if(w){//below
								for(ll next=k+1;next<10;next++){
									dp[i+1][next][1][1][(p+d[i+1]*next)%m]= (dp[i+1][next][1][1][(p+d[i+1]*next)%m]+dp[i][k][0][1][p])%10000;
								}
							}
							else{//suf
								for(ll next=k+1;next<s[i+1]-'0';next++){
									dp[i+1][next][1][1][(p+d[i+1]*next)%m]=(dp[i+1][next][1][1][(p+d[i+1]*next)%m]+dp[i][k][0][0][p])%10000;
								}
								if(s[i+1]>s[i]) dp[i+1][s[i+1]-'0'][1][0][(p+d[i+1]*(s[i+1]-'0'))%m]=(dp[i+1][s[i+1]-'0'][1][0][(p+d[i+1]*(s[i+1]-'0'))%m]+dp[i][k][0][0][p])%10000;
							}
						}
					}
				}
			}
		}
	}
	ll sum=0;
	for(ll i=0;i<10;i++) for(ll j=0;j<2;j++) for(ll k=0;k<2;k++) sum=(sum+dp[L-1][i][j][k][0])%10000;
	/*for(ll i=0;i<L;i++){
		for(ll num=0;num<10;num++){
			for(ll mod=0;mod<m;mod++){
				cout<<"dp["<<i<<"]["<<num<<"][up][bel]["<<mod<<"]="<<dp[i][num][0][1][mod]<<endl;
				cout<<"dp["<<i<<"]["<<num<<"][down][bel]["<<mod<<"]="<<dp[i][num][1][1][mod]<<endl<<endl;
			}
		}
	}
	cout<<endl;
	for(ll i=0;i<L;i++){
		for(ll num=0;num<10;num++){
			for(ll mod=0;mod<m;mod++){
				cout<<"dp["<<i<<"]["<<num<<"][up][suf]["<<mod<<"]="<<dp[i][num][0][0][mod]<<endl;
				cout<<"dp["<<i<<"]["<<num<<"][down][suf]["<<mod<<"]="<<dp[i][num][1][0][mod]<<endl;
			}
		}
	}*/
	return sum-9/m;
}

int main()
{
	cin>>a>>b>>m;
	if(a=="1") printf("%lld\n",solve(b));
	else{
		ll k=a.size()-1;
		while(a[k]=='0'){
			a[k]='9';
			k--;
		}
		if(k==0&&a[k]=='1'){
			string t;
			for(ll i=1;i<a.size();i++) t+="9";
			a=t;
		}
		else{
			a[k]=a[k]-1;
		}
		printf("%lld\n",(10000+solve(b)-solve(a))%10000);
	}
	//dp[??????????????????][??°???][0:up(next)  1:down(next)][0:suf 1:below][mod]
}