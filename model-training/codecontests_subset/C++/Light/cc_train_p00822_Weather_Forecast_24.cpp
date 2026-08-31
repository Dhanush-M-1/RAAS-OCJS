#include<bits/stdc++.h>
#define r(i,n) for(int i=0;i<n;i++)
using namespace std;
bool dp[366][16][8][8][8][8];
int dx[]={-2,2,-1,1,0,0,0,0,0};
int dy[]={0,0,0,0,1,-1,0,2,-2};
int t[366][17],p[4],n;
int main(){
  while(cin>>n,n){
    int ans=0;
    memset(dp,0,sizeof(dp));
    r(i,n)r(j,16)cin>>t[i][j];
    dp[0][5][1][1][1][1]=1;
    r(a,n-1)r(b,16)r(c,7)r(d,7)r(e,7)r(f,7)
    if(dp[a][b][c][d][e][f]){
      int x1=b%4,y1=b/4;
      r(i,9){
        int x=x1+dx[i],y=y1+dy[i],flag=0;
        if(x<0||y<0||2<x||2<y)continue;
        p[0]=y*4+x,p[1]=y*4+x+1;
        p[2]=(y+1)*4+x,p[3]=(y+1)*4+x+1;
        r(k,4)if(t[a+1][p[k]])flag++;
        if(!flag){
          if(p[0]==0)dp[a+1][p[0]][0][d+1][e+1][f+1]=1;
          else if(p[0]==2)dp[a+1][p[0]][c+1][0][e+1][f+1]=1;
          else if(p[0]==8)dp[a+1][p[0]][c+1][d+1][0][f+1]=1;
          else if(p[0]==10)dp[a+1][p[0]][c+1][d+1][e+1][0]=1;
          else dp[a+1][p[0]][c+1][d+1][e+1][f+1]=1;
        }
      }
    }
    r(b,16)r(c,7)r(d,7)r(e,7)r(f,7)
      if(dp[n-1][b][c][d][e][f])ans++;
    if(t[0][5]||t[0][6]||t[0][9]||t[0][10])ans=0;
    cout<<(ans?1:0)<<endl;
  }
}