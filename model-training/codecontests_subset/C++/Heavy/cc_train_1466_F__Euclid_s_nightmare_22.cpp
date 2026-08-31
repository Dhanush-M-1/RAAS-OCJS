#include<bits/stdc++.h>
#define int long long
#define mod 1000000007
using namespace std;
int freex[500005];
int parent[500005];
vector<int> adj[500005];
int finder(int x)
{if(x==parent[x]){return x;}
int z=finder(parent[x]);
parent[x]=z;
return z;
}
void Union(int a,int b)
  {if(finder(a)==finder(b)){return;}
   int x=finder(a);
   int y=finder(b);
   parent[x]=y;
  }
int32_t main()
{ios::sync_with_stdio(0);
 cin.tie(0);
 memset(freex,0,sizeof(freex));
 int n,mi;
 cin>>n>>mi;
 int k;
 vector<int> v;
 for(int i=0;i<500005;i++){parent[i]=i;}
 //Remember to go from 1 to m
 int x,y;
 for(int i=0;i<n;i++)
    {cin>>k;
     if(k==1)
        {cin>>x;y=500004;
        int z=finder(x);
        }
    else
       {//int x,y;
        cin>>x>>y;}
        //cout<<finder(x)<<" "<<finder(y)<<"\n";
        if(finder(x)==finder(y)){continue;}
        v.push_back(i+1);
        freex[x]++;freex[y]++;
        adj[x].push_back(y);
        adj[y].push_back(x);
        Union(x,y);
    }
int ans=1;
map<int,int> m;
for(int i=0;i<500005;i++)
    {if(freex[i]==0){continue;}
        m[finder(i)]++;
    }
for(auto x:m)
    {//cout<<x.second<<"\n";
        for(int y=0;y<x.second-1;y++){ans=ans*2;ans%=mod;}
    }
cout<<ans<<" ";
cout<<v.size()<<"\n";
for(auto x:v){cout<<x<<" ";}
}