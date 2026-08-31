#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int tanku[5] = {5, 7, 5, 7, 7};

int main(){
    
    for(int n; cin >> n, n;){
        vector<int>v(n);
        for(int i = 0; i < n; i++){
            string s;
            cin >> s;
            v[i] = s.size();
        }
        for(int i = 0; i < n; i++){
            int flg = 0;
            int x = 0, y = 0;
            for(int j = i; j < n; j++){
                x += v[j];
                if(x > tanku[y])break;
                if(x == tanku[y]){
                    x = 0;
                    y++;
                }
                if(y == 5){
                    flg = 1;
                    break;
                }
            }
            if(flg){
                cout << i + 1 << endl;
                break;
            }
        }
    }

    return 0;
}

