#include <bits/stdc++.h>
using namespace std;
using LL = long long;

string A,B;
int M;

const LL MOD = 10000;

LL dp[555][10][555][2][2];
//S以下の0modMなジグザグ数の個数を求める
LL solve(string&S){
	int N=S.size();
	int firstdig=S[0]-'0';
	if(N==1){
		return firstdig/M;
	}
	memset(dp,0,sizeof(dp));
	for(int i=1;i<firstdig;++i){
		dp[0][i][i%M][0][0]=1;
		dp[0][i][i%M][1][0]=1;
	}
	dp[0][firstdig][firstdig%M][0][1]=1;
	dp[0][firstdig][firstdig%M][1][1]=1;
	auto addrem=[](LL& ins,LL plr){
		ins+=plr;
		ins%=MOD;
	};
	for(int d=0;d<N-1;++d){
		for(int v=0;v<10;++v){
			for(int r=0;r<M;++r){
				for(int f=0;f<2;++f){
					for(int n=0;n<2;++n){
						LL now=dp[d][v][r][f][n];
						if(n==0){
							if(f){
								for(int nv=v+1;nv<10;++nv){
									addrem(
									dp[d+1][nv][(r*10+nv)%M][!f][n],now
									);
								}
							}else{
								for(int nv=0;nv<v;++nv){
									addrem(
									dp[d+1][nv][(r*10+nv)%M][!f][n],now
									);
								}
							}
						}else{
							int lim=S[d+1]-'0';
							if(f){
								for(int nv=v+1;nv<=lim;++nv){
									addrem(
									dp[d+1][nv][(r*10+nv)%M][!f][(nv==lim)],now
									);
								}
							}else{
								for(int nv=0;nv<min(lim+1,v);++nv){
									addrem(
									dp[d+1][nv][(r*10+nv)%M][!f][(nv==lim)],now
									);
								}
							}
						}
					}
				}
			}
		}
		for(int i=1;i<10;++i){
			addrem(dp[d+1][i][i%M][0][0],1);
			addrem(dp[d+1][i][i%M][1][0],1);
		}
	}
	LL res=0;
	for(int v=0;v<10;++v){
		for(int f=0;f<2;++f){
			for(int n=0;n<2;++n){
				addrem(
				res,dp[N-1][v][0][f][n]
				);
			}
		}
	}
	res -= 9 / M;
	return res;
}

int main(){
	cin>>A;
	cin>>B;
	cin>>M;
	LL L=solve(A);
	LL R=solve(B);
	bool Azig=true;
	if(A.size()>1){
		vector<int>vec;
		for(int i=1;i<A.size();++i){
			if(A[i-1]<A[i]){
				vec.push_back(1);
			}else if(A[i-1]>A[i]){
				vec.push_back(0);
			}else{
				Azig=false;
				break;
			}
		}
		if(Azig){
			for(int j=1;j<vec.size();++j){
				if(vec[j]==vec[j-1]){
					Azig=false;
					break;
				}
			}
		}
	}
	LL ans=R-L;
	if(Azig)ans++;
	ans+=MOD;
	ans%=MOD;
	//cerr<<L<<" "<<R<<endl;
	cout<<ans<<endl;
	return 0;
}

