#include<bits/stdc++.h>
using namespace std;
int main(){
    while(1){
        int N;
        cin >> N;
        if(!N) break;
        string s[N];
        for(int i = 0; i < N; i++) cin >> s[i];
        const vector<int> po = {5, 7, 5, 7, 7};
        for(int i = 0; i < N; i++){
            int index = 0;
            vector<int> yo = po;
            for(int j = i; j < N; j++){
                if(index == 5) break;
                if(yo[index] < s[j].size()) break;
                yo[index] -= s[j].size();
                if(!yo[index]) index++;
            }
            if(index == 5){
                cout << i + 1 << endl;
                break;
            }
        }
    }
    return 0;
}

