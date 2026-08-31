#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, a, b;
    vector<int> v;
    
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> a >> b;
        v.push_back(a + b);
    }
    
    sort(v.begin(), v.end());
    while (1) {
        int cnt = 1;
        bool check = true;
        vector<int> t;
        
        for (int i = 0; i < v.size(); ++i) {
            if (i != v.size() - 1 && v[i] == v[i + 1]) {
                cnt++;
            }
            else {
                if (cnt >= 2)
                    check = false;
                
                if (cnt % 2 == 1)
                    t.push_back(v[i]);
                for (int j = 0; j < cnt / 2; ++j) {
                    t.push_back(v[i] + 1);
                }
                
                cnt = 1;
            }
        }
        
        if (check)
            break;
        
        v = t;
    }
    
    for (auto elem: v) {
        cout << elem << " " << 0 << endl;
    }
    
    return 0;
}