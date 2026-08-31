#include <bits/stdc++.h>
using namespace std;

const int MAX_N=41;

int n,sum,t,ok; string w;
vector<int> words(MAX_N);
vector<int> each={5,7,5,7,7};

int main(){
    cin.tie(0);
    ios::sync_with_stdio(false);
    while(cin >> n,n){
        for (int i=0;i<n;++i){
            cin >> w; words[i]=(int)w.size();
        }
        for (int i=0;i<n;++i){
            t=i,ok=1;
            for (int j=0;j<5;++j){
                sum=0;
                for (int k=t;k<n;++k){
                    sum+=words[k];
                    if (sum==each[j]){t=k+1; break;}
                    if (sum>each[j]){ok=0; break;}
                }
            }
            if (ok){
                cout << i+1 << '\n';
                break;
            }
        }
    }
}
