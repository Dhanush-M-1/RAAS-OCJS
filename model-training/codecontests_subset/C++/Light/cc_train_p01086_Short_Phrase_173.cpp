#include <bits/stdc++.h>
using namespace std;

int tanku[5] = {5,7,5,7,7};

int main(){
    int n;
    while(scanf("%d",&n), n != 0){
        string w[40];
        for(int i=0;i<n;++i)cin >> w[i];
        for(int i=0;i<n;++i){
            int k=0, cnt=0, j=i;
            while(k < 5 && j < n){
                cnt += w[j].size();
                if(cnt > tanku[k])break;
                if(cnt == tanku[k]){
                    ++k;
                    cnt = 0;
                }
                ++j;
            }
            if(k == 5){
                printf("%d\n",i+1);
                break;
            }
        }
    }

    return 0;
}