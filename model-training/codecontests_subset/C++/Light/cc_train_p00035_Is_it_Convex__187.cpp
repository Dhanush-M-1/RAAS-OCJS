#include <stdio.h>

int
main(void)
{
	auto deg = [](double ax, double ay, double bx, double by,
				  double cx, double cy)  -> double {
		    double abx = bx - ax;
		    double aby = by - ay;
		    double acx = cx - ax;
		    double acy = cy - ay;
		 
		    return (abx * acy  -acx * aby);
		};

	char line[80];

	double xa, ya, xb, yb, xc, yc, xd, yd;

	while (true) {
		if (fgets(line, sizeof line, stdin) == NULL) {
			break;
		}
		if (sscanf(line, "%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf,",
				   &xa, &ya, &xb, &yb, &xc, &yc, &xd, &yd) != 8) {
			break;
		}

		double d0 = deg(xa, ya, xb, yb, xd, yd);
		double d1 = deg(xb, yb, xc, yc, xa, ya);
		double d2 = deg(xc, yc, xd, yd, xb, yb);
		double d3 = deg(xd, yd, xa, ya, xc, yc);

        if ((d0 < 0 && d1 < 0 && d2 < 0 && d3 < 0) ||
	        (d0 > 0 && d1 > 0 && d2 > 0 && d3 > 0)) {
            printf("YES\n");
        } else {
            printf("NO\n");
        }
	}

	return 0;
}