#include<iostream>
#define f(X) for(c=0;c<X;c+=v[p++]);if(c-X)continue;
using namespace std;
int main(){
    for(int n;cin>>n,n;){
        int v[50],s,p,c;
        for(s=0;s<n;s++){string t;cin>>t;v[s]=t.size();}
        for(s=p=0;;p=++s){f(5);f(7);f(5);f(7);f(7);cout<<s+1<<endl;break;}
    }
}