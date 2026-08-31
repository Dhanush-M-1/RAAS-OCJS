#include <iostream>
#include <unordered_map>
using namespace std;
int main() {
    int n; cin >> n;
    unordered_map<string, int> m;
    for (int i = 0; i < n; ++i)
    {
        string s; cin >> s;
        ++m[s];
    }
    for (auto i : {"AC", "WA", "TLE", "RE"})
    {
        cout << i << " x " << m[i] << endl;
    }
}