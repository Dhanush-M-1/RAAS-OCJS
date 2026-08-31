#include <iostream>
#include <functional>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int k[5] = {5,7,5,7,7};
int n; 
string str[50];

bool dfs(int s, int c, int sum) {
    if (sum + str[s].length() == k[c]) {
        if (c == 4) return true;
        else return dfs(s+1, c+1, 0);
    }
    else if (sum + str[s].length() > k[c]) return false;
    else return dfs(s+1, c, sum + str[s].length());
}

int main(void){
    while (1) {
        cin >> n;
        if (!n) break;
        for (int i = 0; i < n; i++) cin >> str[i];
        for (int i = 0; i < n; i++) {
            int x = dfs(i, 0, 0);
            if (x == false) continue;
            cout << i+1 << endl;
            break;
        }
    }
    
    return 0;
}