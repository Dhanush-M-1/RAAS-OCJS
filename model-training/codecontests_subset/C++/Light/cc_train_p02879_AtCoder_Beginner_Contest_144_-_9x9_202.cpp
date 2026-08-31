#include<bits/stdc++.h>
using namespace std;
int n, m;

int main(){
	scanf("%d%d", &n, &m);
	printf("%d\n", n < 10 && m < 10 ? n*m : -1);
}