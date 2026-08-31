#include <iostream>
#include <cmath>
using namespace std;
int n;
char s[15];
void dfs(int i, char a){
    if(i == n) {
        cout << s << endl;
        return;
    }
    for(char c = 'a'; c <= char(a + 1); c++)
        s[i] = c, dfs(i + 1, max(c, a));
}
int main() {
    cin >> n;
    s[0] = 'a';
    dfs(1, 'a');
    return 0;
}