#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <string>
#include <functional>
#include <algorithm>
using namespace std;

int main()
{
    int n, a[100];
    while(cin >> n && n) {
        for(int i = 0; i < n; i++) {
            cin >> a[i];
        }
        
        int ret = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - 1 - i; j++) {
                if(a[j] > a[j + 1]) {
                    swap(a[j], a[j + 1]);
                    ret++;
                }
            }
        }
        cout << ret << endl;
    }
}