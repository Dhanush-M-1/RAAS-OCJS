#include <iostream>
#include <stdio.h>
using namespace std;
int main() {
 int n,i,j,k,d[100];
 while(cin >> n) {
	 if (n==0) break;
	 for (i=0;i<n;i++) cin >> d[i];
	 k=0;
	 for (i=1;i<n;i++) for (j=0;j<n-i;j++) if (d[j]>d[j+1]) { swap(d[j],d[j+1]); k++;} 
	 cout << k << endl;
 }
 return 0;
 }