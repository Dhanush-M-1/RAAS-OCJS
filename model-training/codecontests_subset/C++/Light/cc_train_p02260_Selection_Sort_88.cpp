#include<bits/stdc++.h>
using namespace std;

int main()
{
    int N; cin>>N;
    vector<int> a(N);
    for(int i=0;i<N;i++) cin>>a[i];

    int cnt=0;
    for(int i=0;i<=N-2;i++){
        int mn=a[i],idx=i;
        for(int j=i+1;j<N;j++) if(a[j]<mn){
            mn=a[j]; idx=j;
        }
        if(idx!=i) swap(a[i],a[idx]),cnt++;
    }
    for(int i=0;i<N;i++) cout<<a[i]<<(i==N-1? '\n':' ');
    cout<<cnt<<endl;
    return 0;
}
