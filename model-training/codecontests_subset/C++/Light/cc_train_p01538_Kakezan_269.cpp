#include <iostream>
#include <string>
#include <set>

using namespace std;

template<typename T> inline void chmax(T& t, T f){if(t < f)t = f;}

int main(){
    int Q;
    cin >> Q;
    while(Q--){
        int N, R = 0;
        cin >> N;
        set<int> u{N};
        for(; 10 <= N; ++R){
            string s = to_string(N);
            N = 0;
            for(int i=1; i<(int)s.size(); ++i){
                chmax(N, stoi(s.substr(0, i)) * stoi(s.substr(i)));
            }
            if(!u.insert(N).second)N = -1;
        }
        cout << (N < 0? N: R) << '\n';
    }
    return 0;
}