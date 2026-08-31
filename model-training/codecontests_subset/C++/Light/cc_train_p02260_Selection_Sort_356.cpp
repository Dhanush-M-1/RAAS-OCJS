#include <iostream>
#include <vector>
using namespace std;

void swap(int *a,int *b){
    int t = *a;
    *a = *b;
    *b = t;
}
int main() {
    int n,ans=0,i,j,m;
    cin>>n;
    vector<int> a(n);
    for (i=0;i<n;i++) cin>>a[i];
    for (i=0;i<n-1;i++) {
        m=i;
        for (j=i;j<n;j++)if(a[j]<a[m])m=j;
        if(i!=m){swap(a[i],a[m]);ans++;}
        cout<<a[i]<<" ";
    }
    cout<<a[n-1]<<endl;
    cout<<ans<<endl;
    return 0;
}
