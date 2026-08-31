#include<bits/stdc++.h>
using namespace std;

int calc(vector<int>&a){
    int n=a.size();
    if(n<=1)return 0;
    vector<int>b(a.begin(),a.begin()+n/2);
    vector<int>c(a.begin()+n/2,a.end());
    int ret=calc(b)+calc(c);

    int bi=0,ci=0;
    for(int i=0;i<a.size();i++){
        if(bi<b.size()&&(ci==c.size()||b[bi]<=c[ci])){
            a[i]=b[bi++];
        }
        else{
            ret+=n/2-bi;
            a[i]=c[ci++];
        }
    }
    return ret;
}

int main(){
    int N;
    while(cin>>N,N){
        vector<int>a(N);
        for(int i=0;i<N;i++)cin>>a[i];
        cout<<calc(a)<<endl;
    }
    return 0;
}