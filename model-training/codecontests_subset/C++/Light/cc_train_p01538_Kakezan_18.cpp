#include <algorithm>
#include <iostream>
#include <vector>
#include <set>
using namespace std;

string nxt(string s) {
    int ma = -1;
    for (int i = 1; i < s.length(); i++) {
        string s1 = s.substr(0, i);
        string s2 = s.substr(i);
        int mul = stoi(s1) * stoi(s2);
        ma = max(ma, mul);
    }
    return to_string(ma);
}

int solve(string s) {
    int cnt = 0;
    set<string> his;
    while (s.length() > 1) {
        cnt++;
        his.insert(s);
        s = nxt(s);
        if (his.count(s)) return -1;
    }
    return cnt;
}

int main() {
    int Q; cin >> Q;
    while (Q--) {
        string N; cin >> N;
        cout << solve(N) << endl;
    }
    return 0;
}
