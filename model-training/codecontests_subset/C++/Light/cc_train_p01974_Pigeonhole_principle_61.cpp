#include <bits/stdc++.h>

using namespace std;


signed main(){
    int N;cin >> N;
    vector<int> vec;
    for(int i = 0;i < N;i++){
        int b;cin >> b;
        vec.push_back(b);
    }
    for(int i = 0;i < N-1;i++){
        for(int j = i + 1;j < N;j++){
            if(abs(vec.at(i) - vec.at(j)) % (N-1) == 0){
                cout<<vec.at(i)<<" "<<vec.at(j)<<endl;
                return 0;
            }
        }
    }
}

