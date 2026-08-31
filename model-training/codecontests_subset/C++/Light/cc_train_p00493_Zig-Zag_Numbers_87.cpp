#include<cstdio>
#include<cstring>
#include<vector>
#include<queue>
#include<algorithm>
#include<cmath>
#include<climits>
#include<string>
#include<set>
#include<map>
#include<iostream>
using namespace std;
#define rep(i,n) for(int i=0;i<((int)(n));i++)
#define reg(i,a,b) for(int i=((int)(a));i<=((int)(b));i++)
#define irep(i,n) for(int i=((int)(n))-1;i>=0;i--)
#define ireg(i,a,b) for(int i=((int)(b));i>=((int)(a));i--)
typedef long long int lli;
typedef pair<int,int> mp;
#define fir first
#define sec second
#define IINF INT_MAX
#define LINF LLONG_MAX
#define eprintf(...) fprintf(stderr,__VA_ARGS__)

int m;

#define MOD 10000

int dp[505][505][15][2][2]; //keta,amari,sento,zanonaoke,sameok,muki
//p0 .. sameok,p1 .. sameng

bool isgz(string s){
	int r = 0;
	rep(i,s.size()){
		r = (r*10+s[i]-'0')%m;
	}
	if(r%m!=0)return false;
	
	if(s.size()<=1)return true;

	if(s[0]==s[1])return false;
	int d = (s[0]>s[1]?1:0);
	rep(i,s.size()){
		if(!i)continue;
		if(d^(s[i]>s[i-1]?1:0)^(i%2))return false;
	}
	return true;
}

int gzn(string s){
	{
		string ts = "";
		irep(i,s.size()){
			ts += s[i];
		}
		swap(s,ts);
	}
	
	memset(dp,0,sizeof(dp));
	int res=0;
	
	int ls=s.size();
	
	rep(j,10){
		int i = j%m;
		if(i==0)res++;
		rep(k,2){
			if((s[0]-'0')>=j)dp[1][i][j][0][k]=1;
			else dp[1][i][j][1][k]=1;
		}
	}
	
	//printf("i.1 . %d\n",res);
	
	int bm=10%m;
	reg(i,2,ls){
		rep(j,m){
			rep(k,10){
				rep(p,2){
					rep(q,2){
						int& d = dp[i][j][k][p][q]; //sameok
						int c = s[i-1]-'0';
						
						int am = (bm*k)%m;
						//?????????j-am????????????
						int bj = (j-am+m)%m;
						rep(bk,10){
							rep(bp,2){
								if(p==0){
									if(c<k)continue;
									if(c==k && bp==1)continue;
								}
								else{
									if(c>k)continue;
									if(c==k && bp==0)continue;
								}
								
								if(bk==k)continue;
								if(q^(i%2)^(bk<k?1:0))continue;
								
								d = (d+dp[i-1][bj][bk][bp][q])%MOD;
							}
						}
						
						if(i<ls && j==0 && k!=0)res = (res+d)%MOD; //0pad
					}
				}
			}
		}
		bm = (bm*10)%m;
		//printf("i.%d .. %d\n",i,res);
	}
	
	/*
	reg(i,1,ls){
		rep(k,10){
			printf("%d %d : ",i,k);
			rep(j,m){
				printf("(%d %d,%d %d) ",dp[i][j][k][0][0],dp[i][j][k][0][1],dp[i][j][k][1][0],dp[i][j][k][1][1]);
			}
			printf("\n");
		}
	}
	*/
	
	if(ls>1){
		reg(i,1,9){
			rep(k,2){
				res = (res+dp[ls][0][i][0][k])%MOD;
			}
		}
	}
	else{
		res=(s[0]-'0')/m+1;
	}
	
	//printf("%s .. %d\n",s.c_str(),res);
	return res;
}

int main(void){
	string a,b;
	cin >> a >> b >> m;
	int ma = gzn(a);
	int mb = gzn(b);
	if(isgz(a))mb++;
	printf("%d\n",(MOD+mb-ma)%MOD);
	return 0;
}