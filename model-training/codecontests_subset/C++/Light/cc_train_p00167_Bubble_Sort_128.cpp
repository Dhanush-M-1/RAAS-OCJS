#include <bits/stdc++.h>
using namespace std;
int main(void){
    int n,a;
    int count=0;
    std::deque<int> deq;
    while (cin>>n) {
        if (n==0) {
            break;
        } else {
            for (int i=0;i<n;i++) {
                cin>>a;
                deq.emplace_back(a);
            }
            for (int j=0;j<n;j++) {
                for (int k=0;k<n-1;k++) {
                    if (deq[k]>deq[k+1]) {
                        swap(deq[k],deq[k+1]);
                        count++;
                    }
                }
            }
            cout<<count<<endl;
            count=0;
            deq.clear();
        }
    }
}

