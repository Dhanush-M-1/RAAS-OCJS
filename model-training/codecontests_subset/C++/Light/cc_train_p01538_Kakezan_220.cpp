#include <bits/stdc++.h>
using namespace std;

int solve(int x){
    int cnt = 0;
    set<int> st;
    while(x >= 10){
        if(st.count(x)==0) st.insert(x);
        else return -1;
        string s = to_string(x);
        int n = s.size();
        int ma = 0;
        for(int i=1;i<n;i++){
            int a = stoi(s.substr(0,i)), b = stoi(s.substr(i,n-i));
            ma = max(ma, a*b);
        }
        x = ma;
        cnt++;
    }
    return cnt;
}


int main() {
    int Q, N;
    cin >> Q;
    for(int i=0;i<Q;i++){
        cin >> N;
        cout << solve(N) << endl;
    }
    return 0;
}

