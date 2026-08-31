from math import gcd

games, total_points, win_points, draw_points = map(int, input().split())


def win_draw_loss(games, total_points, points_per_win, points_per_draw):

    if total_points > games * points_per_win:
        return -1
    if total_points == games * points_per_win:
        return " ".join([str(games), "0", "0"])

    if total_points == games * points_per_draw:
        return " ".join(["0", str(games), "0"])

    if total_points == 0:
        return " ".join(["0", "0", str(games)])

    if (
        points_per_win % points_per_draw == 0
        and points_per_draw != 1
        and total_points % points_per_draw != 0
    ):
        return -1

    # divisor = int(gcd(gcd(points_per_win, total_points), points_per_draw))
    #
    # # if divisor != 1:
    # #     total_points = int(total_points / divisor)
    # #     points_per_win = int(points_per_win / divisor)
    # #     points_per_draw = int(points_per_draw / divisor)

    if total_points % points_per_win == 0 and total_points / points_per_win < games:
        games_won = int(total_points / points_per_win)

        return " ".join([str(games_won), str(0), str(games - games_won)])

    maximum_win_games = int(total_points / points_per_win)

    if total_points < points_per_win:
        maximum_win_games = 0

    while maximum_win_games:

        # max_points
        if (
            maximum_win_games * points_per_win
            + points_per_draw * (games - maximum_win_games)
            < total_points
        ):
            return -1

        if total_points < points_per_win * maximum_win_games:
            maximum_win_games -= 1
            continue

        if (total_points - (points_per_win * maximum_win_games)) % points_per_draw == 0:
            potential_draw = int((
                total_points - (points_per_win * maximum_win_games)
            ) / points_per_draw)
            # Big int
            if total_points != points_per_win * maximum_win_games + points_per_draw * potential_draw:
                continue

            if potential_draw <= games - maximum_win_games:

                return " ".join(
                    [
                        str(maximum_win_games),
                        str(int(potential_draw)),
                        str(int(games - (maximum_win_games + potential_draw))),
                    ]
                )
            else:
                return -1

        maximum_win_games -= 1

    # 0 games won
    if games * points_per_draw < total_points:
        return -1

    maximum_draw_games = int(total_points / points_per_draw)

    while maximum_draw_games:

        if maximum_draw_games * points_per_draw < total_points:
            return -1

        if maximum_draw_games * points_per_draw == total_points:

            return " ".join(
                ["0", str(maximum_draw_games), str(games - maximum_draw_games)]
            )

    return -1

print(win_draw_loss(games, total_points, win_points, draw_points))
