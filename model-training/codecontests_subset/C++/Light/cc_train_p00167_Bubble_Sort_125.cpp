#include <iostream>
#include <algorithm>
using namespace std;
int main(){int n,i;while(cin>>n&&n){int a[n];int r=0;for(i=0;i<n;)cin>>a[i++];for(i=n-1;i>0;i--){for(int j=1;j<=i;j++){if(a[j-1]>a[j]){swap(a[j-1],a[j]);r++;}}}cout<<r<<endl;}}