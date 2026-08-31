#include <iostream>
#include <algorithm>
#include <set>
using namespace std;

int main(){
    int n;
    cin >> n;
    for(int i=0;i<n;i++){
        int a;
        set<int> s;
        bool f = false;
        cin >> a;

        int j;
        for(j=0;a>=10;j++){
            int cnt = 0;
            for(int k=10;k<=a;k*=10) cnt = max(cnt,(a/k)*(a%k));
            if(s.find(cnt) != s.end()){
                f = true;
                break;
            } else {
                a = cnt;
                s.insert(cnt);
            }
        }
        cout << (f ? -1 : j) << endl;
    }
}