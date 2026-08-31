        // violet apricity
        // Do all I can do.Do good to be good.
//g++  ./violet/run.cpp -o ./violet/run.exe
#include<iostream>
#include<stdio.h>
#include<cstring>
#include<string>
#include<algorithm>
#include<vector>
#include<math.h>
#include<map>
#include<sstream>
#include<numeric>
#include<queue>
#include<iomanip>
#include<fstream>

#define STD using namespace std;
#define ll long long
#define db double
#define ldb long double
#define IOS std::ios::sync_with_stdio(false),std::cin.tie(0),std::cout.tie(0);
#define MAX 88888888
#define INF 0x3f3f3f3f
#define r0 return 0;
#define SYP system("pause");
#define endl '\n'
using namespace std;


int main()
{
    IOS
    //ifstream cin("E:\\ACMdream\\in.txt");
    //ofstream cout("E:\\ACMdream\\out.txt");
    int t;cin>>t;
    while(t--){
        int k,n,m;cin>>k>>n>>m;
        vector<int>a,b;
        vector<int>ans;
        for(int i=1;i<=n;i++){
            int d;cin>>d;a.push_back(d);
        }
        for(int i=1;i<=m;i++){
            int d;cin>>d;b.push_back(d);
        }
        bool yes=0;
        int x=0,y=0;
        while(1){
            if(x==n&&y==m)yes=1;
            if(x<n&&a[x]<=k){
                ans.push_back(a[x]);
                x++;if(a[x-1]==0)k++;
                continue;
            }
            if(y<m&&b[y]<=k){
                ans.push_back(b[y]);
                y++;if(b[y-1]==0)k++;
                continue;
            }
            break;
        }
        if(yes){
            for(auto i:ans)cout<<i<<' ';cout<<'\n';
        }
        else cout<<-1<<'\n';
    }
    //SYP
}