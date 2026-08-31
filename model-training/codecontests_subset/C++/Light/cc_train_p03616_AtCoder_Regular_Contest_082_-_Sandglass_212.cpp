#include<bits/stdc++.h>
#define pi 3.1415926535897932384626
using namespace std;
      
struct P{
  int x,y;
  bool operator < (const P &a )const{
    //if(y!=a.y)
    return y<a.y;
  };
};

int a,b,c,d,i,k,n,m,e,dx[10]={1,0,-1,0,1,1,-1,-1},dy[10]={0,1,0,-1,1,-1,1,-1};
int o[101101];
int l[101111][4];
int j[1];

long long x,y,z,mod=1000000007;
//string r;
char r[1];

P u[1];
queue<int> q;
//stack<P> s;

vector<int> v[1111];

bool as(P a,P b)
{
  return a.x<b.x;
}

int main()
{
  scanf("%d %d",&a,&b);
  l[0][0]=a;
  for(int t=1;t<=b+1;t++)
  {
    if(t<=b) scanf("%d",&o[t]);
    else o[t]=1000000010;
    if(t%2)
    {
      l[t][0]=max(l[t-1][0]-(o[t]-o[t-1]),0);
      l[t][1]=max(l[t-1][1]-(o[t]-o[t-1]),0);
      l[t][2]=l[t-1][2];
      if(l[t][1]==0)l[t][3]=min(a-l[t][2],l[t-1][3]-l[t-1][1]+(o[t]-o[t-1]));
      else l[t][3]=l[t-1][3];
    }
    else
    {
      l[t][0]=min(l[t-1][0]+(o[t]-o[t-1]),a);
      l[t][1]=min(l[t-1][1]+(o[t]-o[t-1]),a);
      l[t][3]=l[t-1][3];
      if(l[t][0]==a)l[t][2]=min(a-l[t][3],l[t-1][2]+(l[t-1][0]+(o[t]-o[t-1])-a));
      else l[t][2]=l[t-1][2];
    }
  }
  b++;
  scanf("%d",&c);
  for(int t=1;t<=c;t++)
  {
    scanf("%d %d",&n,&m);
    for(;o[e+1]<=n&&e<b;e++);
    int p;
    if(m<=l[e][3]) p=l[e][1];
    else if(a<=m+l[e][2]) p=l[e][0];
    else p=l[e][1]+m-l[e][3];
    if(e%2) p+=n-o[e];
    else p-=n-o[e];
    printf("%d\n",max(min(a,p),0));
  }
}
//3


