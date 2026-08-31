#include <bits/stdc++.h>
#define N 366
using namespace std;
int n,A[N][4][4];
int mem[N][3][3][7][7][7][7];
int dx[]={0,0,0,1,-1};
int dy[]={0,1,-1,0,0};

int check(int d,int x,int y){
  if(x<0||y<0||x>=3||y>=3)return 0;
  for(int i=0;i<2;i++)
    for(int j=0;j<2;j++)if(A[d][y+i][x+j]) return 0;
  return 1;
}

void getABCD(int x,int y,int &A,int &B,int &C,int &D){
  A++,B++,C++,D++;
  if(x==0&&y==0) A = 0;
  if(x==2&&y==0) B = 0;
  if(x==0&&y==2) C = 0;
  if(x==2&&y==2) D = 0;
}

int dfs(int num=0,int x=1,int y=1,int A=1,int B=1,int C=1,int D=1){
  if(num==n-1) return 1;
  if(mem[num][x][y][A][B][C][D]++) return 0;
  
  for(int i=0;i<5;i++)
    for(int j=0,nx=x,ny=y;j<2;j++){
      nx+=dx[i],ny+=dy[i];
      int nA=A,nB=B,nC=C,nD=D;
      getABCD(nx,ny,nA,nB,nC,nD);
      if(nA==7||nB==7||nC==7||nD==7)continue;
      if(check(num+1,nx,ny)&&dfs(num+1,nx,ny,nA,nB,nC,nD))return 1;
    }
  return 0;
}

int main(){
  while(cin>>n,n){
    for(int i=0;i<n;i++)
      for(int j=0;j<16;j++) cin>>A[i][j/4][j%4];

    memset(mem,0,sizeof(mem));
    cout<<check(0,1,1)*dfs()<<endl; 
  }
  return 0;
}