#include <bits/stdc++.h>
#define REP(i,n)for (int i=0;i<(n);i++)
#define PB push_back
#define MP make_pair
#define ALL(a) (a).begin(),(a).end()
#define ll long long
using namespace std;
int d[5]={5,7,5,7,7};
int num[40];
int n;
bool rec(int s){
    int sum=0;
    int t[5];
    REP(i,5)t[i]=d[i];
    int ss=0;
    for(int i=s;i<n;i++){
        if(t[ss]>0)t[ss]-=num[i];
        else{
            ss++;
            t[ss]-=num[i];
        }
    }
    REP(i,5)if(t[i]!=0)return false;
    return true;
}
int main(){
    while(1){
        cin>>n;
        if(n==0)break;
        REP(i,n){
            string s;cin>>s;
            num[i]=s.size();
        }
        REP(i,n){
            if(rec(i)){
                cout<<i+1<<endl;
                break;
            }
        }
    }
}