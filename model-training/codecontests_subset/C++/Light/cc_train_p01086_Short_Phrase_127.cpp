#include <iostream>
#include<bits/stdc++.h>
using namespace std;
int n,cnt,ans;
string s;
vector<int> v;
int f(int a){
    int t[5]={5,7,5,7,7};
    cnt=0;
    while(1){
        t[cnt]-=v[a];
        if(t[cnt]==0)cnt++;
        else if(t[cnt]<0)return 0;
        a++;
        if(cnt==5)return a+1;
    }
}
int main(void){
    while(1){
    cin>>n;
    v={};
    if(n==0)return 0;
    for(int i=0;i<n;i++){
        cin>>s;
        v.push_back(s.size());
    }
    for(int i=0;i<n;i++){
        ans=f(i);
        if(ans!=0){
            cout<<i+1<<endl;
            break;
        }
    }
    }
}

