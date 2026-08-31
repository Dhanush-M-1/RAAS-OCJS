#include <cstdio>
#include <cstring>
#include <algorithm>
#define MOD 531441
using namespace std;

int n;
int fie[366][4][4];
bool dp[2][81*81*81];
int rx[9]={0,1,2,0,1,2,0,1,2};
int ry[9]={0,0,0,1,1,1,2,2,2};
int data[81*81*81][4][4];
int data2[9][4][4];

bool check(int v,int bit,int next){
	for(int i=0;i<4;i++){
		for(int j=0;j<4;j++){
			if(data2[next][j][i]==1 && fie[v][j][i]==1)return false;
			if(v>=6 && data[bit][j][i]+data2[next][j][i]==0)return false;
		}
	}
	return true;
}

int main(void){
	for(int i=0;i<81*81*81;i++){
		int ni=i;
		for(int j=0;j<6;j++){
			data[i][rx[ni%9]][ry[ni%9]]=1;
			data[i][rx[ni%9]+1][ry[ni%9]]=1;
			data[i][rx[ni%9]][ry[ni%9]+1]=1;
			data[i][rx[ni%9]+1][ry[ni%9]+1]=1;
			ni/=9;
		}
	}
	for(int i=0;i<9;i++){
		data2[i][rx[i]][ry[i]]=1;
		data2[i][rx[i]+1][ry[i]]=1;
		data2[i][rx[i]][ry[i]+1]=1;
		data2[i][rx[i]+1][ry[i]+1]=1;
	}
	while(1){
		scanf("%d",&n);
		if(n==0)break;
		for(int i=0;i<n;i++){
			for(int j=0;j<4;j++){
				for(int k=0;k<4;k++){
					scanf("%d",&fie[i][k][j]);
				}
			}
		}
		memset(dp,false,sizeof(dp));
		int now=1,prev=0;
		if(fie[0][1][1]+fie[0][2][1]+fie[0][2][2]+fie[0][1][2]==0)dp[prev][4]=true;
		for(int i=1;i<n;i++){
			for(int j=0;j<81*81*81;j++){
				if(dp[prev][j]){
					for(int k=0;k<9;k++){
						if(rx[j%9]!=rx[k] && ry[j%9]!=ry[k])continue;
						if(check(i,j,k)){
							//printf("%d %d %d\n",i,j,k);
							dp[now][(j*9+k)%MOD]=true;
						}
					}
				}
			}
			swap(now,prev);
			memset(dp[now],false,sizeof(dp[now]));
		}
		int res=0;
		for(int i=0;i<81*81*81;i++){
			if(dp[prev][i])res=1;
		}
		printf("%d\n",res);
	}
	return 0;
}