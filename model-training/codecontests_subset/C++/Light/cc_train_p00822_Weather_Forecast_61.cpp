#include<bits/stdc++.h>
using namespace std;
struct state{int p,y,x,a,b,c,d;};
int dy[]={-1,0,1,0};
int dx[]={0,1,0,-1};

int n;
int  t[367][4][4];
bool visited[367][3][3][8][8][8][8];

int solve(){
  int K=7;
  if(t[0][1][1]||t[0][1][2]||t[0][2][1]||t[0][2][2])return 0;
  
  memset(visited,0,sizeof(visited));    
  queue< state > Q;    
  Q.push((state){0,1,1,1,1,1,1});
  while(!Q.empty()){
    state s=Q.front();Q.pop();
    if(s.p==n-1)return 1;
    
    for(int i=0;i<4;i++){
      for(int j=0;j<=2;j++){
        int np=s.p+1;
        int ny=s.y+dy[i]*j;
        int nx=s.x+dx[i]*j;        
        if(ny<0 || 2<ny)continue;
        if(nx<0 || 2<nx)continue;
        if(t[np][ny][nx])continue;
        if(t[np][ny+1][nx])continue;
        if(t[np][ny][nx+1])continue;
        if(t[np][ny+1][nx+1])continue;
        int na=s.a+1,nb=s.b+1,nc=s.c+1,nd=s.d+1;          
        if(ny==0&&nx==0)na=0;
        else if(ny==0&&nx==2)nb=0;
        else if(ny==2&&nx==0)nc=0;
        else if(ny==2&&nx==2)nd=0;
        if(na==K||nb==K||nc==K||nd==K)continue;
        if(visited[np][ny][nx][na][nb][nc][nd])continue;
        visited[np][ny][nx][na][nb][nc][nd]=true;
        Q.push((state){np,ny,nx,na,nb,nc,nd});
      }
    }
  }
  return 0;
}

int main(){
  while(1){
    cin>>n;
    if(n==0)break;
    memset(t,0,sizeof(t));
    for(int i=0;i<n;i++)
      for(int j=0;j<4;j++)
        for(int k=0;k<4;k++)
          cin>>t[i][j][k];
    cout<<solve()<<endl;
    
  }
  return 0;
}