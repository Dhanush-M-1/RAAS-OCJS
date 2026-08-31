#include<bits/stdc++.h>
#define N 366
#define L 16
#define M 9
#define D 7
using namespace std;
bool dp[N][M][D][D][D][D];
int d[N][L];
int dy[5]={0,-1,0,1,0};
int dx[5]={0,0,1,0,-1};
int n;

int main(){
  while(1){
    cin>>n;
    if(!n)break;
    memset(d,0,sizeof(d));
    for(int i=0;i<n;i++)
      for(int j=0;j<L;j++)
	cin>>d[i][j];
    memset(dp,0,sizeof(dp));
    dp[0][4][1][1][1][1]=true;
    bool ans=false;
    for(int i=0;i<n-1;i++)
      for(int j=0;j<M;j++)
	for(int k1=0;k1<D;k1++)
	  for(int k2=0;k2<D;k2++)
	    for(int k3=0;k3<D;k3++)
	      for(int k4=0;k4<D;k4++){
		if(!dp[i][j][k1][k2][k3][k4])continue;
		int y=j/3,x=j%3;
		for(int l=0;l<5;l++){
		  for(int l2=0;l2<5;l2++){
		    if(!(l2==0||l==l2))continue;
		    int ny=y+dy[l]+dy[l2],nx=x+dx[l]+dx[l2];
		    if(ny<0||nx<0||3<=ny||3<=nx)continue;
		    int nj=ny*3+nx,flag=1;
		    if(nj<3){
		      if(d[i+1][nj]||d[i+1][nj+1]||d[i+1][nj+4]||d[i+1][nj+5])flag=0;
		    }else if(nj<6){
		      if(d[i+1][nj+1]||d[i+1][nj+2]||d[i+1][nj+5]||d[i+1][nj+6])flag=0;
		    }
		    else if(d[i+1][nj+2]||d[i+1][nj+3]||d[i+1][nj+6]||d[i+1][nj+7])flag=0;
		    int nk1=k1,nk2=k2,nk3=k3,nk4=k4;
		    if(nj==0)nk1=0;
		    else if(nk1==6)flag=0;
		    else nk1++;
		    if(nj==2)nk2=0;
		    else if(nk2==6)flag=0;
		    else nk2++;
		    if(nj==6)nk3=0;
		    else if(nk3==6)flag=0;
		    else nk3++;
		    if(nj==8)nk4=0;
		    else if(nk4==6)flag=0;
		    else nk4++;
		    if(flag)dp[i+1][nj][nk1][nk2][nk3][nk4]=true;
		  }
		}
	      }
    for(int i=0;i<M;i++)
      for(int k1=0;k1<D;k1++)
	for(int k2=0;k2<D;k2++)
	    for(int k3=0;k3<D;k3++)
	      for(int k4=0;k4<D;k4++)
		if(dp[n-1][i][k1][k2][k3][k4])ans=true;
    if(d[0][5]||d[0][6]
       ||d[0][9]||d[0][10])ans=false;
    cout<<ans<<endl;
  }
  return 0;
}