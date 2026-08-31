#include <map>
#include <iostream>
using namespace std;
int main() {
    int n; cin >> n;
    map<string, int> m;
    while (n--) {
        string s; cin >> s;
        m[s]++;
    }
    for (string s : {"AC", "WA", "TLE", "RE"})
        cout << s << " x " << m[s] << endl;
}
