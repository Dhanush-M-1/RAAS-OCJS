#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;
    int tanka[]={5,7,5,7,7};
    while(cin>>n,n){
        vector<string> w(n);
        for(int i=0;i<n;i++)cin>>w[i];

        for(int i=0;i<n;i++){
            int inde=0;
            int cnt=0;
            for(int j=i;j<n;j++){
                cnt+=w[j].size();
                if(cnt==tanka[inde]){
                    inde++;
                    cnt=0;
                }
                if(inde==5) break;
            }
            if(inde==5){
                cout<<i+1<<endl;
                break;
            }

        }

    }

    return 0;
}